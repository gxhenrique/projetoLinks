package com.gxhenrique.projetoLinks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxhenrique.projetoLinks.entity.Link;
import com.gxhenrique.projetoLinks.repository.LinkRepository;

@Service
public class LinkService {
	
	@Autowired
	private LinkRepository linkRepository;
	
	public List<Link> fidAll(){
		return linkRepository.findAll();
	}
	
	public Link findById(Long id) {
		
		Optional<Link> obj = linkRepository.findById(id);
		
		return obj.get();
	}
	
	public void delete(Long id) {
		
		linkRepository.deleteById(id);
	}
	
	public Link postLink(Link link) {
		return linkRepository.save(link);
	}
	
	
	public Link putLink(Long id, Link link) {
		Link entity = linkRepository.findById(id).get();
		updateData(entity, link);
		return linkRepository.save(entity);
	}

	private void updateData(Link entity, Link link) {
		entity.setTitle(link.getTitle());
		entity.setUrl(link.getUrl());
		entity.setDisplayOrder(link.getDisplayOrder());
		entity.setVisible(link.getVisible());
		
		
	}
	
	
	public Link patchLink(Long id, Link link) {
		Link entity = linkRepository.findById(id).get();
		patchUpdateData(entity, link);
		return linkRepository.save(entity);
	}

	private void patchUpdateData(Link entity, Link link) {
		
		if(link.getTitle() != null) {
			entity.setTitle(link.getTitle());
		}
		
		if(link.getUrl() != null) {
			entity.setUrl(link.getUrl());
		}
		
		if(link.getDisplayOrder() != null) {
			entity.setDisplayOrder(link.getDisplayOrder());
		}
		
		if(link.getVisible() != null) {
			entity.setVisible(link.getVisible());
		}
		
		
	}
}
