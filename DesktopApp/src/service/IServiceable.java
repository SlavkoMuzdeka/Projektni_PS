package service;

public interface IServiceable {

	public Boolean delete(String id);
	public Boolean addOne(Object item);
	public Boolean addAll(Object items);
	public Object getOne(String id);
	public Object getAll(String searchString);
	public Boolean edit(String id);
	
}

