package com.github.sdpwz1994.bookmark.provider;

import com.intellij.ide.bookmarks.Bookmark;
import com.intellij.ide.bookmarks.BookmarkItem;
import com.intellij.ide.bookmarks.BookmarkManager;
import com.intellij.ide.bookmarks.BookmarksFavoriteListProvider;
import com.intellij.ide.favoritesTreeView.AbstractFavoritesListProvider;
import com.intellij.ide.favoritesTreeView.FavoritesManager;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.RowIcon;
import com.intellij.util.ui.EmptyIcon;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author sundapeng
 * @version 1.0
 * @date 2020/12/16
 */
public class BookmarksFavoriteListProviderEnhance extends AbstractFavoritesListProvider {

    public BookmarksFavoriteListProviderEnhance(@NotNull Project project) {
        super(project, "voyage");
    }

    @Override
    public String getListName(Project project) {
        return "voyage";
    }

    @Override
    public int getWeight() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void customizeRenderer(ColoredTreeCellRenderer renderer, JTree tree, @NotNull Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.customizeRenderer(renderer, tree, value, selected, expanded, leaf, row, hasFocus);
        if (value == null) {
            throw new RuntimeException("render exception");
        }

        renderer.clear();
        renderer.setIcon(EmptyIcon.ICON_8);
        if (value instanceof Bookmark) {
            Bookmark bookmark = (Bookmark)value;
            BookmarkItem.setupRenderer(renderer, this.myProject, bookmark, selected);
            if (renderer.getIcon() != null) {
                RowIcon icon = new RowIcon(3, RowIcon.Alignment.CENTER);
                icon.setIcon(bookmark.getIcon(), 0);
                icon.setIcon(JBUI.scale(EmptyIcon.create(1)), 1);
                icon.setIcon(renderer.getIcon(), 2);
                renderer.setIcon(icon);
            } else {
                renderer.setIcon(bookmark.getIcon());
            }
        } else {
            renderer.append(this.getListName(this.myProject));
        }
        Bookmark test = new Bookmark(this.myProject, myProject.getWorkspaceFile(), 3, "test");
        AbstractTreeNode<Bookmark> child = new AbstractTreeNode<Bookmark>(this.myProject, test) {
            @NotNull
            public Collection<? extends AbstractTreeNode> getChildren() {
                List var10000 = Collections.emptyList();
                if (var10000 == null) {
                    throw new RuntimeException("null children");
                }

                return var10000;
            }

            public boolean canNavigate() {
                return test.canNavigate();
            }

            public boolean canNavigateToSource() {
                return test.canNavigateToSource();
            }

            public void navigate(boolean requestFocus) {
                test.navigate(requestFocus);
            }

            protected void update(PresentationData presentation) {
                presentation.setPresentableText(test.toString());
                presentation.setIcon(test.getIcon());
            }
        };
        child.setParent(this.myNode);
        this.myChildren.add(child);
    }
}
