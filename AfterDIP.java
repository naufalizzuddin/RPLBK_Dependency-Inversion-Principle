
package rplbkDIPafter;

interface paymentMethod {
	void pay(int amount);
}

class Gopay implements paymentMethod{
	@Override
	public void pay(int amount) {
		System.out.println("Pembayaran sebesar Rp." + amount + " menggunakan Gopay.");
	}
}

class OVO implements paymentMethod{ //penambahan payment dapat langsung mengimplementasikan paymentMethod
	@Override
	public void pay(int amount) {
		System.out.println("Pembayaran sebesar Rp." + amount + " menggunakan OVO.");
	}
}

class tokoOnline {
	private paymentMethod payment; //class utama bergantung pada class abstraksi paymentMethod
	public tokoOnline(paymentMethod payment) {
		this.payment = payment;
	}
	public void checkout(int amount) {
		payment.pay(amount);
	}
}

class Main {
	public static void main(String[] args) {
		tokoOnline paymentGopay = new tokoOnline(new Gopay());
		tokoOnline paymentOVO = new tokoOnline(new OVO());
        paymentGopay.checkout(25000);
        paymentOVO.checkout(100000);
	}
}
