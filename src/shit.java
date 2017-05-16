import org.omg.CORBA.Bounds;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Hold down an arrow key to have your player1 move around the screen.
 */
public class shit extends Application {

	private static final double W = 800, H = 600;

	private static final String player_IMAGE_LOC = "http://i.imgur.com/m2oiHVE.png";
	private static final String ball_IMAGE_LOC = "http://i.imgur.com/BAUjKsH.png";
	private static final String line_IMAGE_LOC = "http://i.imgur.com/0kUCCK2.png";
	private static final String start_IMAGE_LOC = "https://cdn.discordapp.com/attachments/228977378880126986/307487429881888768/pongshit.png";
	private Image playerImage;
	private Image ballImage;
	private Image lineImage;
	private Image startImage;
	private Node player1;
	private Node player2;
	private Node ball;
	private Node line;
	private Node start;
	private double deltaX, deltaY;
	private double v;

	boolean goNorth1, goSouth1, goNorth2, goSouth2, moving;

	@Override
	public void start(Stage stage) throws Exception {
		playerImage = new Image(player_IMAGE_LOC);
		ballImage = new Image(ball_IMAGE_LOC);
		lineImage = new Image(line_IMAGE_LOC);
		startImage = new Image(start_IMAGE_LOC);

		player1 = new ImageView(playerImage);
		player2 = new ImageView(playerImage);
		ball = new ImageView(ballImage);
		line = new ImageView(lineImage);
		start = new ImageView(startImage);

		Group group = new Group(player1, player2, ball, line, start);

		moveplayer1To(50, H / 2);
		moveplayer2To(W - 50, H / 2);
		moveballTo(W/2, H/2);
		movelineTo(W / 2, H / 2);
		movestartTo(W / 2, H / 2);

		Scene scene = new Scene(group, W, H, Color.BLACK);

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case W:
					goNorth1 = true;
					break;
				case S:
					goSouth1 = true;
					break;
				case UP:
					goNorth2 = true;
					break;
				case DOWN:
					goSouth2 = true;
					break;
				case SPACE:
					moving = true;
					deltaX = 1;
					deltaY = 1;
					v = 5;
					break;
				}
			}
		});

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case W:
					goNorth1 = false;
					break;
				case S:
					goSouth1 = false;
					break;
				case UP:
					goNorth2 = false;
					break;
				case DOWN:
					goSouth2 = false;
					break;
				}
			}
		});

		stage.setScene(scene);
		stage.show();

		AnimationTimer timer = new AnimationTimer() {
			
			public void handle(long now) {
				int d = 0;
				int e = 0;
				
				if (goNorth1)
					d -= 10;
				if (goSouth1)
					d += 10;
				if (goNorth2)
					e -= 10;
				if (goSouth2)
					e += 10;
				if (moving) {
					if(ball.getBoundsInParent().getMaxY() >= H-v || ball.getBoundsInParent().getMinY() <= v) {
						deltaY *= -1;
						v *= 1.01;
					} else if(ball.getBoundsInParent().getMaxX() >= W-v || ball.getBoundsInParent().getMinX() <= v) {
						deltaX *= -1;
						v *= 1.01;
					} else if(ball.getBoundsInParent().getMinX() <= 50 && player1.getBoundsInParent().getMaxY() > ball.getBoundsInParent().getMaxY() && player1.getBoundsInParent().getMinY() < ball.getBoundsInParent().getMinY()) {
						deltaX *= -1;
						v *= 1.01;
					} else if(ball.getBoundsInParent().getMaxX() >= W-50 && player2.getBoundsInParent().getMaxY() > ball.getBoundsInParent().getMaxY() && player2.getBoundsInParent().getMinY() < ball.getBoundsInParent().getMinY()) {
						deltaX *= -1;
						v *= 1.01;
					}
				}
				
				moveplayer1By(0, d);
				moveplayer2By(0, e);
				moveballBy(deltaX * v, deltaY * v);
			}
		};
		timer.start();
	}

	private void moveplayer1By(int dx, int dy) {
		if (dx == 0 && dy == 0)
			return;

		final double cx = player1.getBoundsInLocal().getWidth() / 2;
		final double cy = player1.getBoundsInLocal().getHeight() / 2;

		double x = cx + player1.getLayoutX() + dx;
		double y = cy + player1.getLayoutY() + dy;

		moveplayer1To(x, y);
	}

	private void moveplayer1To(double x, double y) {
		final double cx = player1.getBoundsInLocal().getWidth() / 2;
		final double cy = player1.getBoundsInLocal().getHeight() / 2;

		if (x - cx >= 0 && x + cx <= W && y - cy >= 0 && y + cy <= H) {
			player1.relocate(x - cx, y - cy);
		}
	}

	private void moveplayer2By(int dx, int dy) {
		if (dx == 0 && dy == 0)
			return;

		final double cx = player2.getBoundsInLocal().getWidth() / 2;
		final double cy = player2.getBoundsInLocal().getHeight() / 2;

		double x = cx + player2.getLayoutX() + dx;
		double y = cy + player2.getLayoutY() + dy;

		moveplayer2To(x, y);
	}

	private void moveplayer2To(double x, double y) {
		final double cx = player2.getBoundsInLocal().getWidth() / 2;
		final double cy = player2.getBoundsInLocal().getHeight() / 2;

		if (x - cx >= 0 && x + cx <= W && y - cy >= 0 && y + cy <= H) {
			player2.relocate(x - cx, y - cy);
		}
	}

	private void moveballBy(double dx, double dy) {
		if (dx == 0 && dy == 0)
			return;

		final double cx = ball.getBoundsInLocal().getWidth() / 2;
		final double cy = ball.getBoundsInLocal().getHeight() / 2;

		double x = cx + ball.getLayoutX() + dx;
		double y = cy + ball.getLayoutY() + dy;
		
		moveballTo(x, y);
	}

	private void moveballTo(double x, double y) {
		final double cx = ball.getBoundsInLocal().getWidth() / 2;
		final double cy = ball.getBoundsInLocal().getHeight() / 2;

		if (x - cx >= 0 && x + cx <= W && y - cy >= 0 && y + cy <= H) {
			ball.relocate(x - cx, y - cy);
		}
	}

	private void movelineBy(int dx, int dy) {
		if (dx == 0 && dy == 0)
			return;

		final double cx = line.getBoundsInLocal().getWidth() / 2;
		final double cy = line.getBoundsInLocal().getHeight() / 2;

		double x = cx + line.getLayoutX() + dx;
		double y = cy + line.getLayoutY() + dy;

		movelineTo(x, y);
	}

	private void movelineTo(double x, double y) {
		final double cx = line.getBoundsInLocal().getWidth() / 2;
		final double cy = line.getBoundsInLocal().getHeight() / 2;

		if (x - cx >= 0 && x + cx <= W && y - cy >= 0 && y + cy <= H) {
			line.relocate(x - cx, y - cy);
		}
	}
	
	private void movestartBy(int dx, int dy) {
		if (dx == 0 && dy == 0)
			return;

		final double cx = start.getBoundsInLocal().getWidth() / 2;
		final double cy = start.getBoundsInLocal().getHeight() / 2;

		double x = cx + start.getLayoutX() + dx;
		double y = cy + start.getLayoutY() + dy;

		movestartTo(x, y);
	}

	private void movestartTo(double x, double y) {
		final double cx = start.getBoundsInLocal().getWidth() / 2;
		final double cy = start.getBoundsInLocal().getHeight() / 2;

		if (x - cx >= 0 && x + cx <= W && y - cy >= 0 && y + cy <= H) {
			start.relocate(x - cx, y - cy);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}