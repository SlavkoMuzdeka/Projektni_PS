package service;

public interface IServiceable {

	public Boolean delete(String id);
	public Boolean addOne(Object item);
	public Boolean addAll(Object items);
	public void getOne(String id);
	public void getAll(String searchString);
	public Boolean edit(String id);
	
}

