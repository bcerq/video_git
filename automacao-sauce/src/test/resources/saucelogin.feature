#Author: bssc@outlook.com
@featLogin
Feature: Pagina de login
  Eu como usuário desejo realizar login no site

Background: 
    Given que eu acesse "https://www.saucedemo.com"
 	  
  Scenario: login ok enter
    And preencho login valido
    And preencho senha valida
    When pressiono enter
    Then valido login
   
  Scenario: login ok clicar
    And preencho login valido
    And preencho senha valida
    When clico login
    Then valido login
    
 Scenario: senha errada
    And preencho login valido
    But preencho senha invalida
    When clico login
    Then valido nao login
    
 Scenario: username errado
    But preencho login invalido
    And preencho senha valida
    When clico login
    Then valido nao login
    
 Scenario: sem login
    And nao preencho login 
    And preencho senha valida
    When clico login
    Then valido nao login
    
 Scenario: sem senha
    And preencho login valido 
    And nao preencho senha
    When clico login
    Then valido nao login
    
 Scenario: sem login e sem senha
    And nao preencho login  
    And nao preencho senha 
    When clico login
    Then valido nao login
    
