package com.cers.noticeboardapi.resource;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cers.noticeboardapi.model.NoticeBoardModel;
import com.cers.noticeboardapi.repository.NoticeBoardRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class NoticeBoardResource {

	
	@Autowired
	NoticeBoardRepository noticeBoardRepository;
	
	
	@GetMapping("/notices")
	public ResponseEntity<?> listOfAllNotices(Pageable pageable){
		return new ResponseEntity<> (noticeBoardRepository.findAll(pageable),HttpStatus.OK);
	}
	
	@GetMapping("/notices/{id}")
	public ResponseEntity<?> noticeById (@PathVariable (value = "id") Long id) {
		return new ResponseEntity<>(noticeBoardRepository.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/notices")
	public ResponseEntity<?> saveNewNotice (@RequestBody @Valid NoticeBoardModel notice) {
		notice.setPublishDate(LocalDate.now());
		return new ResponseEntity<>(noticeBoardRepository.save(notice), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/notices/{id}")
	public ResponseEntity<?> deleteNotice(@PathVariable(value="id") Long id) {
        Optional<NoticeBoardModel> noticeBoardSpecify = noticeBoardRepository.findById(id);
        if(!noticeBoardSpecify.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        	noticeBoardRepository.delete(noticeBoardSpecify.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
	
	
    @PutMapping("/notices/{id}")
    public ResponseEntity<?> updateNotice(@PathVariable(value="id") Long id,
                                          @RequestBody @Valid NoticeBoardModel notice) {
        Optional<NoticeBoardModel> noticeBoardSpecify = noticeBoardRepository.findById(id);
        if(!noticeBoardSpecify.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            notice.setId(noticeBoardSpecify.get().getId());
            notice.setPublishDate(LocalDate.now());
            return new ResponseEntity<>(noticeBoardRepository.save(notice), HttpStatus.OK);
        }
    }
	
	
}
