package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

   protected final int tileCoordinate;
   
   private static final Map<Integer,EmptyTile> EMPTY_TILES_CACHE =creatAllPossibleEmptyTiles();
   //this HashMap save 64 empty tiles beacuse of creatAllPossibleEmptyTiles method.
    //creatAllPossibleEmptyTile method is for making 64 Empty tile class and connect those classes with Integer like i.
    private static Map<Integer, EmptyTile> creatAllPossibleEmptyTiles() {
        final Map<Integer,EmptyTile> emptyTileMap=new HashMap<>();
        for(int i=0;i<64;i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return EmptyTile;
        //you can make this hashMap Immutable with google library which you need to import.
        //the code for making hashMap Immutable is ImmutableMap.copyOf(#hashMap name).
        //you can also make this HashMap immutable with jdk libarys with using Collections.unmodifiableMao(#HashMap Name).
    }

    private Tile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }
    //this class is abstract so we cant make any object from it.
    //creatTile is a method for making Tiles
    public static Tile creatTile(final int tileCoordinate,final Piece piece){
        return piece!=null ? new OccupiedTile(tileCoordinate,piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();
    public static final class EmptyTile extends Tile{

        private EmptyTile(final int coordinate){
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
        private OccupiedTile(int tileCoordinate,Piece piece) {
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
