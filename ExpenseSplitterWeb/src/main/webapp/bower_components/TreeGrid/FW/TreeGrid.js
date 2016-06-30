// Handles Creation of TreeGrid
/*
 * createTreeGrid
 * Generates a TreeGrid on the page based on the given values
 * @param id - id of the TreeGrid to use, must be unique and should be the same of id used when created TreeGrid object. If a grid with given id exists already, it will be deleted.
 * @param url - URL/Servlet Name of TreeGridServlet
 * @param tag - The div tag where the TreeGrid will display inside
 * @param beanName - The name of the class that extends TreeGridBaseBean which creates the TreeGrid object
 * @param tech - Technology being used. Valid values are: struts, jsf
 */
function createTreeGrid(id, url, tag, beanName, tech, windowId) {
	var grid = Grids[id];
	if (null != grid)
		grid.Dispose();

	TreeGrid({
		Cache : 0,
		Layout : {
			Method : "POST",
			Url : url + "?id=" + id + "&type=layout&beanName=" + beanName
					+ "&tech=" + tech + "&windowId="+windowId,
			Cache : 0
		},
		Data : {
			Method : "POST",
			Url : url + "?id=" + id + "&type=data&beanName=" + beanName
					+ "&tech=" + tech + "&windowId="+windowId,
			Cache : 0
		},
		Upload : {
			Url : url + "?id=" + id + "&type=upload&beanName=" + beanName
					+ "&tech=" + tech + "&windowId="+windowId
		},
		Page : {
			Url : "dummy"
		}
	}, tag);

};

Grids.OnSelectAll = function(grid) {
	grid.StartUpdate();

	var rootRow = grid.GetFirst();
	if (isAllSelected(grid, rootRow)) {
		// selectAll(grid, rootRow, 0);
		grid.SelectRow(rootRow, 0);
		selectAllNextSiblingsAcrossPages(grid, rootRow, 0);
	} else {
		// selectAll(grid, rootRow, 1);
		grid.SelectRow(rootRow, 1);
		selectAllNextSiblingsAcrossPages(grid, rootRow, 1);
	}

	grid.EndUpdate(null, null);

	return true;

};

function selectAllNextSiblings(G, row, select) {
	var sibling = row.nextSibling;
	while (sibling != null) {
		G.SelectRow(sibling, select);
		sibling = sibling.nextSibling;
	}
}

function selectAllNextSiblingsAcrossPages(G, row, select) {
	var sibling = row.nextSibling;
	while (sibling != null) {
		G.SelectRow(sibling, select);
	if(sibling.nextSibling == null)
		sibling = G.GetNextSibling(sibling);
	else
		sibling = sibling.nextSibling;
	}
}


//Handles Selection of rows
Grids.OnSelect = function(G, row, deselect) {

	G.StartUpdate();
	if (G.GetValue(row, 'Col0') == deselect) {
		G.SetValue(row, 'Col0', !deselect, 0);
	}

	// If selecting row, select all child rows
	if (!deselect) {
		if (row.firstChild != null) {

			G.SelectRow(row.firstChild, 1);

			selectAllNextSiblings(G, row.firstChild, 1);
		}
		// Select my parent if all its' children are selected and recurse up
		if (row.parentNode.Level > -1) {
			row.Selected = 1;
			var firstSibling = row.parentNode.firstChild;
			selectApplicableParents(G, firstSibling);
		}
	} else {
		// Deselect all children if all selected - this case may never happen
		row.Selected = 0;
		if (isAllChildrenSelected(G, row)) {

			G.SelectRow(row.firstChild, 0);

			selectAllNextSiblings(G, row.firstChild, 0);
		}
		G.SelectRow(row.parentNode, 0);


	}
	G.EndUpdate(null, null);

};

//Selects any parent of row that has all it's children selected
//G - TreeGrid
//row - row whose parent might be selected
function selectApplicableParents(G, row) {
	if (isAllSelected(G, row)) {
		if (row.parentNode.Level > -1) {
			G.SelectRow(row.parentNode, 1);
			//selectRowAndCheckbox(G, row.parentNode, 1);
			selectApplicableParents(G, row.parentNode);
		}
	}
}


function selectAllChildren(G, row, select) {
	var child = row.firstChild;
	while (child != null) {
		G.SelectRow(child, select);
		child = child.nextSibling;
	}
}
//Checks if all children and next siblings are selected
//G - TreeGrid
//row - row to start at
function isAllSelected(G, row) {

	var selected = true;
	// If I am not selected, return null (a row isn't selected)
	if (!G.GetAttribute(row, null, "Selected"))
		return false;
	// Recurse on my first child
	// This will check my first child, it's first child, and my childrens
	// siblings
	var child = row.firstChild;
	if (child != null)
		selected = isAllSelected(G, child);
	if (!selected)
		return selected;
	//
	var sibling = row.nextSibling;
	if (sibling != null)
		selected = isAllSelected(G, sibling);
	return selected;
}

//Checks if all children of row are selected
//G - TreeGrid
//row - row to check children of
function isAllChildrenSelected(G, row) {

	return isAllSelected(G, row.firstChild);
}