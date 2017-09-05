package pacman.graphics.tiles;

import pacman.graphics.Map;

/**
 *
 * @author Bren
 */
public class WallTile extends Tile {

    private int myId;
    public WallTile(int... id) {
        super(null, 3);
        getDetailedProperties(id);

    }

    private void getDetailedProperties(int[] id) {
        int[][] tileMap = Map.detailedTiles;
        
        try {
            for (int i = 0; i < Map.getWIDTH(); i++) {
                for (int j = 0; j < Map.getHEIGHT(); j++) {
                   System.out.println(tileMap[i][j]);
                    for (int k : id) {
                        
                        if (tileMap[i][j] == k) {
                            super.setId(k);
                           // System.out.println(k);
                        }
                    }
                }
            }
            switch (super.getId()) {
                case 3:
                    super.texture = Map.walls.get("DBL-BL-Corner"); break;
                case 10:
                    super.texture = Map.walls.get("DBL-BR-Corner"); break;
                case 11:
                    super.texture = Map.walls.get("DBL-Horizontal"); break;
                case 12:
                    super.texture = Map.walls.get("DBL-TL-Corner"); break;
                case 13:
                    super.texture = Map.walls.get("DBL-TR-Corner"); break;
                case 14:
                    super.texture = Map.walls.get("DBL-Vertical"); break;
                case 15:
                    super.texture = Map.walls.get("SNG-BL-Corner"); break;
                case 16:
                    super.texture = Map.walls.get("SNG-BR-Corner"); break;
                case 17:
                    super.texture = Map.walls.get("SNG-Horizontal"); break;
                case 18:
                    super.texture = Map.walls.get("SNG-TL-Corner"); break;
                case 19:
                    super.texture = Map.walls.get("SNG-TR-Corner"); break;
                case 20:
                    super.texture = Map.walls.get("SNG-Vertical"); break;

            }

        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
