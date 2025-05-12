package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RandomStateNavigator<T> {

	private final List<T> history;
	private int currentPosition;
	private final Supplier<T> generator;

	public RandomStateNavigator(Supplier<T> generator) {
		this.history = new ArrayList<>();
		this.generator = generator;
		this.currentPosition = -1;
	}

	public T next() {
		currentPosition++;

		if (currentPosition == history.size()) {
			history.add(generator.get());
		}

		return history.get(currentPosition);
	}

	public T previous() {
		if (currentPosition <= 0) {
			currentPosition = 0;
			System.out.println("[Start of history]");
			return current();
		}
		currentPosition--;
		return history.get(currentPosition);
	}

	public T current() {
		if (currentPosition < 0 || currentPosition >= history.size()) {
			return null;
		}
		return history.get(currentPosition);
	}

	public int getCurrentPosition() {
		return currentPosition;
	} 

	public void reset() {
		history.clear();
		currentPosition = -1;
	}

	public List<T> getFullHistory() {
		return new ArrayList<>(history);
	}

	public static void main(String[] args) {
		RandomStateNavigator<Integer> navigator = new RandomStateNavigator<>(() -> new Random().nextInt(100));

		System.out.println("→ " + navigator.next());
		System.out.println("→ " + navigator.next());
		System.out.println("→ " + navigator.next());

		System.out.println("← " + navigator.previous());
		System.out.println("← " + navigator.previous());
		System.out.println("← " + navigator.previous());

		System.out.println("→ " + navigator.next());
		System.out.println("→ " + navigator.next());
		System.out.println("→ " + navigator.next());
	}
}
