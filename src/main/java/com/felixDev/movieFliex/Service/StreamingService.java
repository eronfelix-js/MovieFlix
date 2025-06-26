package com.felixDev.movieFliex.Service;

import com.felixDev.movieFliex.Controller.Response.StreamingResponse;
import com.felixDev.movieFliex.Entity.Streaming;
import com.felixDev.movieFliex.Repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    @Autowired
    private StreamingRepository streamingRepository;

    public Streaming criar(Streaming streaming){
        return streamingRepository.save(streaming);
    }

    public List<Streaming> listar(){
        return streamingRepository.findAll();
    }

    public Optional<Streaming> listarPorId(long id){
        Optional<Streaming> listarPorId = streamingRepository.findById(id);
        return listarPorId;
    }

    public void deletar(long id){

    }




}
