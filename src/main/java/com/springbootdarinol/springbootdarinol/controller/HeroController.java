package com.springbootdarinol.springbootdarinol.controller;

import com.springbootdarinol.springbootdarinol.model.Hero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hero")
public class HeroController {

    public List<Hero> heroes = new ArrayList<>();

    @GetMapping
    public List<Hero> getHeroes(){
        return heroes;
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<Optional<Hero>> getHero(@PathVariable("heroId") Long id){
        Optional<Hero> hero1 = heroes.stream().filter(h -> h.getId() == id).findFirst();
        if(!hero1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hero1, HttpStatus.OK);
    }

    @PutMapping("/{heroId}")
    public Optional<Hero> getHero(@RequestBody Hero hero, @PathVariable("heroId") Long id){
        Optional<Hero> hero1 = heroes.stream().filter(h -> h.getId() == id).findFirst();
        if(hero1.isPresent()){
            hero1.get().setName(hero.getName());
            hero1.get().setDamage(hero.getDamage());
            return hero1;
        } else {
            return null;
        }
    }

    @PostMapping
    public Hero addHero(@RequestBody Hero hero){
        heroes.add(hero);
        return hero;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHero(@PathVariable("id") Long id){
        Optional<Hero> hero1 = heroes.stream().filter(h -> h.getId() == id).findFirst();
        if(!hero1.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            heroes.remove(hero1.get());
            return new ResponseEntity<>("success deleted",HttpStatus.OK);
        }
    }

    @PatchMapping("/{id}")
    public Optional<Hero> getHero(@PathVariable("id") Long id, @RequestParam Boolean isMarriage){
        Optional<Hero> hero1 = heroes.stream().filter(h -> h.getId() == id).findFirst();
        if(hero1.isPresent()){
            hero1.get().setIsMarriage(isMarriage);
            return hero1;
        } else {
            return null;
        }
    }
}
