package com.github.sdpwz1994.bookmark;

import com.intellij.ide.dnd.aware.DnDAwareTree;
import com.intellij.ide.favoritesTreeView.FavoritesListNode;
import com.intellij.ide.favoritesTreeView.FavoritesTreeNodeDescriptor;
import com.intellij.ide.favoritesTreeView.FavoritesTreeViewPanel;
import com.intellij.ide.favoritesTreeView.FavoritesViewTreeBuilder;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.util.Collection;

public class BookmarkGroupMoveEnhance extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Project project = e.getProject();
        FavoritesTreeNodeDescriptor[] root = e.getData(FavoritesTreeViewPanel.CONTEXT_FAVORITES_ROOTS_DATA_KEY);
        FavoritesViewTreeBuilder builder = e.getData(FavoritesTreeViewPanel.FAVORITES_TREE_BUILDER_KEY);
        DnDAwareTree dnDAwareTree = e.getData(FavoritesTreeViewPanel.FAVORITES_TREE_KEY);
        TreePath treePath = dnDAwareTree.getAnchorSelectionPath();
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        node.setUserObject("123456");
        AbstractTreeNode newNode = new FavoritesListNode(project, "123", "123");
        Collection<AbstractTreeNode> children = builder.getRoot().getChildren();
        children.add(newNode);
        builder.queueUpdate().createSetDoneRunnable().run();
        System.out.println(1);
    }
}
