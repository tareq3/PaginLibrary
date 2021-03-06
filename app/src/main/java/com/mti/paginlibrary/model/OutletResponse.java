package com.mti.paginlibrary.model;

public class OutletResponse{
	private int nextPage;
	private Result result;
	private boolean error;

	public void setNextPage(int nextPage){
		this.nextPage = nextPage;
	}

	public int getNextPage(){
		return nextPage;
	}

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
		return result;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"OutletResponse{" + 
			"next_page = '" + nextPage + '\'' + 
			",result = '" + result + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}
