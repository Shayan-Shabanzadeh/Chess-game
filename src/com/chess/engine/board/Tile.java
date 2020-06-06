package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

   protected final int tileCoordinate;
   
   private static final Map<Integer,EmptyTile> EMPTY_TILES=creatAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> creatAllPossibleEmptyTiles() {
        final Map<Integer,EmptyTile> emptyTileMap=new HashMap<>();
        for(int i=0;i<64;i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return emptyTileMap;
        //you can make this hashMap Immutable with google library which you need to import.
        //the code for making hashMap Immutable is ImmutableMap.copyOf(#hashMap name).
    }

    private Tile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }

    public static Tile creatTile(final int tileCoordinate,final Piece piece){
        return piece!=null ? new OccupiedTile(tileCoordinate,piece) : EMPTY_TILES.get(tileCoordinate);
    }

    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();
    public static final class EmptyTile extends Tile{

        EmptyTile(final int coordinate){
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

    }

    public static final class OccupiedTile extends Tile{
       private final Piece piece;
        public OccupiedTile(int tileCoordinate,Piece piece) {
            super(tileCoordinate);
            this.piece=piece;
        }

        @Override
        public  boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
           return this.piece;
        }
    }
}
