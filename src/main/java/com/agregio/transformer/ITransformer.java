package com.agregio.transformer;

import java.util.List;

public interface ITransformer<E,M> {
	
	M toModel(E entity);
	
	E toEntity(M model);
	
	List<E> toEntities(List<M> model);
	
	List<M> toModel(List<E> entity);


}
