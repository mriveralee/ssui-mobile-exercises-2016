package com.mikeriv.ssui_2016.puzzlegame.model;

/**
 * Created by mlrivera on 9/4/16.
 */
public class PuzzleGameBoard {

    private PuzzleGameTile[][] mTileGrid;
    private int mRows;
    private int mColumns;

    public PuzzleGameBoard(int size) {
       this(size, size);
    }

    public PuzzleGameBoard(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException(
                    "GameBoard must have width/height dimensions greater than 0");
        }
        mRows = rows;
        mColumns = columns;
        mTileGrid = new PuzzleGameTile[mRows][mColumns];
    }

    public int getRowsCount() {
        return mRows;
    }

    public int getColumnsCount() {
        return mColumns;
    }

    public int getTotalTileCount() {
        return mRows * mColumns;
    }

    /**
     * Sets the tile at the row,col position in the game board
     * @param tile the tile to set
     * @param row the row to set the tile in
     * @param col the col to set the tile in
     */
    public void setTile(PuzzleGameTile tile, int row, int col) {
        throwOutOfBoundsExceptionIfNecessary(row, col);
        mTileGrid[row][col] = tile;
    }

    /**
     * get the tile at the row,col position in the game board
     * @param row the row to set the tile in
     * @param col the col to set the tile in
     */
    public PuzzleGameTile getTile(int row, int col) {
        throwOutOfBoundsExceptionIfNecessary(row, col);
        return mTileGrid[row][col];
    }


    /**
     * Checks if the tile at row, col is empty
     * @param row the row of the tile to check
     * @param col the col of the tile to checks
     * @return true if the tile exists and is empty; false if the tile is not empty, or null
     */
    public boolean isEmptyTile(int row, int col) {
        throwOutOfBoundsExceptionIfNecessary(row, col);
        // TODO check if the PuzzleGameTile at row, col is empty
        // Null counts as false
        return false;
    }

    /**
     * Clears all the tiles on the game board
     */
    public void reset() {
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mColumns; j++) {
                mTileGrid[i][j] = null;
            }
        }
    }

    /**
     * Checks if two tiles neighbor eachother on the gameboard along the vertical and horizontal
     * axes:
     *      // We want to check the neighbors along the horizontal and vertical axis
     * The 1's below represent the neighbors of a tile called X. 0's are not neighbors)
     * |0 | 1 | 0
     * |1 | X | 1
     * |0 | 1 | 0
     * @param firstTileRow - the first tile's row index
     * @param firstTileCol - the first tile's col index
     * @param secondTileRow - the second tile's row index
     * @param secondTileCol - the second tile's col index
     * @return true if the tiles are neighbors
     */
    public boolean areTilesNeighbors(
            int firstTileRow,
            int firstTileCol,
            int secondTileRow,
            int secondTileCol) {
        throwOutOfBoundsExceptionIfNecessary(firstTileRow, firstTileCol);
        throwOutOfBoundsExceptionIfNecessary(secondTileRow, secondTileCol);
        // TODO - check if tiles are neighborss
        return false;

    }

    /**
     * Swaps the tile in the game board at (firstTileRow, firstTileCol) with the tile at
     * (secondTileRow, secondTileCol) if they are within the bounds of the game board
     * @param firstTileRow - row index of first tile
     * @param firstTileCol - col index of first tile
     * @param secondTileRow - row index of second tile
     * @param secondTileCol - col index of second tile
     */
    public final void swapTiles(
            int firstTileRow,
            int firstTileCol,
            int secondTileRow,
            int secondTileCol) {
        throwOutOfBoundsExceptionIfNecessary(firstTileRow, firstTileCol);
        throwOutOfBoundsExceptionIfNecessary(secondTileRow, secondTileCol);

       // TODO - swap two tiles at the given indices
    }

    /**
     * checks if the given row, col position is within the bounds of the game board
     * @param row
     * @param col
     * @return true if the row, col is within the game board
     */
    private boolean isWithinBounds(int row, int col) {
        if (row < 0 || row >= mRows || col < 0 || col >= mColumns) {
            return false;
        }
        return true;
    }

    /**
     * Helper to check if a row, col is within bounds and throw an out of bounds exception if necessary
     * @param row
     * @param col
     * @throws IndexOutOfBoundsException when the row, col combination is out of bounds of the game
     * board
     */
    private final void throwOutOfBoundsExceptionIfNecessary(
            int row,
            int col)
            throws IndexOutOfBoundsException {
        if (!isWithinBounds(row, col)) {
            throw new IndexOutOfBoundsException("row,col combination is out of board's dimensions");
        }
    }

}
