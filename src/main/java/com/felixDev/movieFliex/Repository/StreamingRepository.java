package com.felixDev.movieFliex.Repository;

import com.felixDev.movieFliex.Entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
