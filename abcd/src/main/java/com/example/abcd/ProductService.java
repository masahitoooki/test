package com.example.abcd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    //全件
    public List<Product> findAll(){
        return repository.findAll();
    }

    //1件
    public Product findById(long id){
        return repository.findById(id).get();
    }

    //追加
    public void save(Product product){
        repository.save(product);
    }

    //削除
    public void delete(long id){

        repository.deleteById(id);
    }
}
