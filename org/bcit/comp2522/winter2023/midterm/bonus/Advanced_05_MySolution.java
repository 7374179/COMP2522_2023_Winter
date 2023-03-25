package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Advanced_05_MySolution {
    // The Grid class implements the Iterable<GridItem> interface
    // and overrides the iterator() method. The iterator() method returns
    // an instance of the GridIterator class, which overrides the hasNext()
    // and next() methods to sequentially iterate through each element
    // in the grid array.

    // In addition, the main() method calls the createGrid() method to create
    // a Grid object and uses a for-each loop to print each GridItem element
    // in the Grid object.
    private static class Grid implements Iterable<GridItem> {
        private final GridItem[][] grid;

        public Grid(int rows, int cols) {
            this.grid = new GridItem[rows][cols];
        }

        public void createGrid() {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = new GridItem(String.format("(%d,%d)", i, j));
                }
            }
        }

        @Override
        public Iterator<GridItem> iterator() {
            return new GridIterator();
        }

        private class GridIterator implements Iterator<GridItem> {
            private int rowIndex = 0;
            private int colIndex = 0;

            @Override
            public boolean hasNext() {
                return rowIndex < grid.length;
            }

            @Override
            public GridItem next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to iterate over");
                }
                GridItem currentItem = grid[rowIndex][colIndex];
                colIndex++;
                if (colIndex == grid[rowIndex].length) {
                    colIndex = 0;
                    rowIndex++;
                }
                return currentItem;
            }
        }
    }

    private static class GridItem {
        private final String value;

        public GridItem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Grid grid = new Grid(3, 4);
        grid.createGrid();
        for (GridItem item : grid) {
            System.out.println(item.getValue());
        }
    }
}

