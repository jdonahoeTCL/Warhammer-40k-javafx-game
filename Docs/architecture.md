#Team ID40k
##Software Architecture Document


#Table of Contents
1. Introduction
2. Purpose
3. Game Architecture
4. Diagram
  
#1. Introduction

This game has been developed as a team project for the Software Engineering class in Fall 2016 at Indiana University Southeast. The team consists of three students ( Ryan , Joshua , and Aliasghar) which each of them had taken part to develop this game. 
  
#2. Purpose

The purpose in this game (Warhammer 40k board ) is to command units and defeat your opponent. The combat includes movement, charging, long-range, and melee components. Use your units in this turn based combat game to defeat the enemy unit and win the battle. It allows two players from two different machines to combat one another.  

#3. Game Architecture

Game Environment - A game environment consisting of two units, guns, resources, and the map. The map is the playing field - the background for the units and resources.

turn-based strategy - It is a type of wargame where the players focus on building an army and attacking enemy units. 

Units - A controllable game entity that can move weapons and they will be armed with a weapons and several shooting scales. 

Player - The entity which makes the decisions and controls the actions of the units in a game through an interface. 
  

 

#4. Class Diagram

![Architecture Diagram](https://s22.postimg.org/y0ga5xur5/Class_Diagram.png)
