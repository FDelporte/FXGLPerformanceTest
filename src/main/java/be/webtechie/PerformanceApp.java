package be.webtechie;

import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static com.almasb.fxgl.dsl.FXGL.spawn;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;

/**
 * Main class of the application
 */
public class PerformanceApp extends GameApplication {

    private static int numberOfItems = 50;

    /**
     * Types of objects we are going to use in this application.
     */
    public enum EntityType {
        ITEM
    }

    /**
     * Reference to the factory which will defines how all the types must be created.
     */
    private final PerformanceFactory factory = new PerformanceFactory();

    /**
     * Player object we are going to use to provide to the factory so it can start a bullet from the player center.
     */
    private Entity player;

    /**
     * Main entry point where the application starts.
     *
     * @param args Start-up arguments
     */
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                numberOfItems = Integer.valueOf(args[0]);
            } catch (Exception ex) {
                System.err.println("Incorrect argument given: " + ex.getMessage());
            }
        }
        launch(args);
    }

    /**
     * General settings. For now only the title is set, but a longer list of options is available.
     *
     * @param settings The settings of the game which can be further extended here.
     */
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("JavaFX performance test - " + numberOfItems + " items");
        settings.setProfilingEnabled(true);
    }

    /**
     * Initialization of the game by providing the {@link EntityFactory}.
     */
    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(this.factory);

        for (int i = 0; i < numberOfItems; i++) {
            spawn("item");
        }
    }

    /**
     * Initialization of the physics to detect e.g. collisions.
     */
    @Override
    protected void initPhysics() {
        /*onCollisionBegin(EntityType.BULLET, EntityType.ENEMY, (bullet, enemy) -> {
            bullet.removeFromWorld();
            enemy.removeFromWorld();
        });

        onCollisionBegin(EntityType.ENEMY, EntityType.PLAYER, (enemy, player) -> {
            showMessage("You Died!", () -> {
                getGameController().startNewGame();
            });
        });*/
    }
}