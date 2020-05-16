package data;

public interface Treeable{

//	@formatter:off

	void setPrev (Queueable queueable);
	void setPost (Queueable queueable);

	Queueable getPrev ();
	Queueable getPost ();

//	@formatter:on

}