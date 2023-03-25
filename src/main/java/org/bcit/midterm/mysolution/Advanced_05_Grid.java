package src.main.java.org.bcit.midterm.mysolution;

import java.util.Iterator;

public class Advanced_05_Grid implements Iterable<Advanced_05_GridItem>{
    private Advanced_05_GridItem[][] grid;

    public Advanced_05_Grid() {
        createGrid();
    }

    public void createGrid() {
        grid = new Advanced_05_GridItem[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = new Advanced_05_GridItem(String.format("%d%d", i, j));
            }
        }
    }

    @Override
    public Iterator<Advanced_05_GridItem> iterator() {
        return new GridIterator();
    }

    private class GridIterator implements Iterator<Advanced_05_GridItem> {
        private int row;
        private int col;

        public GridIterator() {
            row = 0;
            col = 0;
        }

        @Override
        public boolean hasNext() {
            return row < 5 && col < 5;
        }

        @Override
        public Advanced_05_GridItem next() {
            if (!hasNext()) {
                throw new RuntimeException("No more elements in GridIterator");
            }
            Advanced_05_GridItem result = grid[row][col];
            if (col == 4) {
                col = 0;
                row++;
            } else {
                col++;
            }
            return result;
        }
    }
}
