package rplbkDIPbefore;

class Gopay {
	public void pay(int amount) {
		System.out.println("Pembayaran sebesar Rp." + amount + " menggunakan Gopay.");
	}
}

class OVO {
	public void pay(int amount) {
		System.out.println("Pembayaran sebesar Rp." + amount + " menggunakan OVO.");
	}
}

class tokoOnline {
	private Gopay paymentGopay;
	private OVO paymentOVO;
	public tokoOnline() {
	     this.paymentGopay = new Gopay(); // Ketergantungan langsung
	     this.paymentOVO = new OVO();
	}
	
	public void checkoutGopay(int amount) {
		paymentGopay.pay(amount); // Ketergantungan pada implementasi spesifik
	}
	public void checkoutOVO(int amount) {
		paymentOVO.pay(amount);
	}
}



class Main {
	public static void main(String[] args) {
	     tokoOnline store = new tokoOnline();
	     store.checkoutGopay(50000);
	     store.checkoutOVO(100000);
	}
}
