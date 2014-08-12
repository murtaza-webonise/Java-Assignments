import java.util.Random;

class chopStick {

	private boolean isUsed;

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean usedFlag) {
		isUsed = usedFlag;
	}
}

class Philosopher implements Runnable {

	private static final int MAX_EATING_TIME = 1000;
	private static final int MAX_THINKING_TIME = 800;
	private final chopStick leftchopStick;
	private final chopStick rightchopStick;
	private State state;
	static int counter = 0;
	String name = null;
	private final Random randomise = new Random();
	Thread t;

	public enum State {
		EATING, THINKING, WAITING
	}

	public Philosopher(chopStick leftchopStick, chopStick rightchopStick) {
		// TODO Auto-generated constructor stub

		this.leftchopStick = leftchopStick;
		this.rightchopStick = rightchopStick;
		name = "philosopher" + counter++;
		System.out.println(name + " Started");
		t = new Thread(this, name);
		t.start();

	}

	private void eat() throws InterruptedException {

		synchronized (leftchopStick) {
			while (leftchopStick.isUsed() || rightchopStick.isUsed())
				try {
					this.setPhilosopherState(Philosopher.State.WAITING);
					leftchopStick.wait();
				} catch (InterruptedException e) {
				}
			synchronized (rightchopStick) {
				while (leftchopStick.isUsed() || rightchopStick.isUsed())
					try {
						this.setPhilosopherState(Philosopher.State.WAITING);
						rightchopStick.wait();
					} catch (InterruptedException e) {
					}
				try {

					Thread.sleep(1);

					leftchopStick.setUsed(true);
					rightchopStick.setUsed(true);
					this.setPhilosopherState(Philosopher.State.EATING);
					Thread.sleep(randomise.nextInt(MAX_EATING_TIME));

				} finally {
					leftchopStick.setUsed(false);
					rightchopStick.setUsed(false);
					leftchopStick.notify();
					rightchopStick.notify();
				}
			}
		}

		think();
	}

	private void think() throws InterruptedException {
		this.setPhilosopherState(Philosopher.State.THINKING);
		Thread.sleep(randomise.nextInt(MAX_THINKING_TIME));

	}

	private void setPhilosopherState(State _state) {
		this.state = _state;
		System.out.println(this.state + ", " + name + ";");

	}

	public State getPhilosopherState() {
		return state;
	}

	@Override
	public void run() {

		try {
			eat();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Succesfully finished: " + name);
	}
}

public class dinningPhilosopher {
	public static void main(String args[]) {
		chopStick chopStick[] = new chopStick[6];
		for (int i = 0; i < chopStick.length; i++)
			chopStick[i] = new chopStick();

		new Philosopher(chopStick[4], chopStick[0]);
		new Philosopher(chopStick[0], chopStick[1]);
		new Philosopher(chopStick[1], chopStick[2]);
		new Philosopher(chopStick[2], chopStick[3]);
		new Philosopher(chopStick[3], chopStick[4]);

	}

}
