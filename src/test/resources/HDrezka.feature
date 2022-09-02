Feature: Проверка авторизации

  Background:
  Given Пользователь зашел на сайт

    @hooks
      @close
  Scenario:
    When Клик на кнопку войти
    And Логин
    Then Проверка отображения профиля