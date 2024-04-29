package Controller;

public class ConfigException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorText;
	
	public ConfigException() {
		super();
		this.errorText = "Il y a une erreur dans le fichier de configuration.";
	}
	
	public String getErrorText() {
		return this.errorText;
	}
	
	@Override
	public String getMessage() {
		return this.errorText;
	}
}
