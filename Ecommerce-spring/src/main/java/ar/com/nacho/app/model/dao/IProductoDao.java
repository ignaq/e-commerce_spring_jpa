package ar.com.nacho.app.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import ar.com.nacho.app.model.entity.Producto;

public interface IProductoDao extends PagingAndSortingRepository<Producto, Long>{

}
