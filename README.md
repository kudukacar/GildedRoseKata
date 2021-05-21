# Gilded Rose Kata
A code exercise for refactoring legacy code

## Run Backend Tests
1. [Install Java](https://java.com/en/download/help/download_options.html)
2. [Install JDK 15.0.2](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html)
3. Clone repository by typing the following in the terminal: git clone https://github.com/kudukacar/GildedRoseKata.git
4. In your terminal, navigate to the 'backend' folder
5. Enter in the application.properties file your choice of username and password as follows:  
    USERNAME=your username
    PASSWORD=password=your password
6. Type the following in the terminal to run the tests: ./gradlew test
## Run Android Tests
1. Follow steps 1-3 in 'Run Backend Tests' above
2. In your terminal, navigate to the 'android' folder
3. Type the following in the terminal to run the tests: ./gradlew test
## Run Frontend Tests
1. [Install Node](https://nodejs.dev/learn/how-to-install-nodejs)
2. Follow step #3 above if you haven't cloned the repository
3. In your terminal, navigate to the 'frontend' folder
4. Type the following in the terminal to run the tests:  npm test
## Running the frontend Application locally
1. Navigate to the 'backend' folder
2. Follow step #5 in "Run Backend Tests" if you haven't already
3. `./gradlew build` to update the .jar file with your changes
4. `./gradlew bootRun` to run locally
5. Navigate to the 'frontend' folder
6. Create a .env file in the frontend folder and enter the username and password you created above as follows:
    REACT_APP_USERNAME=your username
    REACT_APP_PASSWORD=your password
7. Type the following in the terminal: npm start
8. See the application at:  http://localhost:3000/
