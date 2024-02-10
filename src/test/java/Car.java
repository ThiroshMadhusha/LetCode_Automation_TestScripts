
class Car {
	
	void bodyParts() {
		System.out.println("Hello");
	}
}
class Van extends Car{
	
	void bodyParts() {
		
		super.bodyParts();
		System.out.println("World");
	}
}
