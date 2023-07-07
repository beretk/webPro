package com.lec11_account;
//accountNo, ownerName, balance, cardNo, deposit() withdraw(), infoPrint(), infoString(), pay()
public class CreditLineAccount extends CheckingAccount {
	private int creditLine; // ī���ѵ�
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, 
			int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, 
			int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	// ca1.pay("1324132413241234", 10000)
	@Override
	public void pay(String cardNo, int amount) {
		if(cardNo.equals(getCardNo())) { // �ùٸ� ī���ȣ�� ��� 
			if(creditLine >= amount) { // ���Ұ���
				creditLine -= amount ;//creditLine = creditLine - amount; �ѵ��� amount��ŭ ����
				System.out.printf("%s�� %d�� �����Ͽ� �ѵ� %�� ���ҽ��ϴ�\n", 
							getOwnerName(), amount, creditLine);
			}else { // �ܾ׺������� ���� �Ұ�
				System.out.println(getOwnerName()+"�� �ܾ׺������� ���� �Ұ��մϴ�");
			}
		}else {
			System.out.println("��ȿ�� ī���ȣ�� �ƴմϴ�");
		}
	}
}




