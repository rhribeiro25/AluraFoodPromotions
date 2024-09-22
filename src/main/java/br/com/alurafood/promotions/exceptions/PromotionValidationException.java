package br.com.alurafood.promotions.exceptions;

public class PromotionValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PromotionValidationException(String mensagem) {
		super(mensagem);
	}

}
