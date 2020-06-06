package com.chess.engine.pieces;
public class Piece {

    protected final int piecePossition;
    protected final Alliance pieceAlliance;

    public Piece(final int piecePossition,final Alliance pieceAlliance) {
        this.piecePossition = piecePossition;
        this.pieceAlliance = pieceAlliance;
    }
}
