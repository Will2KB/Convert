package Controller;

public class ConfigException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorText;
	private Exception subException;
	
	public ConfigException(Exception subException) {
		this.subException = subException;
		this.errorText = "Il y a une erreur dans le fichier de configuration.";
	}
	
	public String getErrorText() {
		return this.errorText;
	}
	
	@Override
	public String getMessage() {
		return this.errorText;
	}
	
	public Exception getSubException() {
		return this.subException;
	}
	
}
