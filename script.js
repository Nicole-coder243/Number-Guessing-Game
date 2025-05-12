// Initialize variables
const randomNumber = Math.floor(Math.random() * 1000) + 1;
let attempts = 0;
const maxAttempts = 5;

// DOM elements
const guessInput = document.getElementById("guessInput");
const submitGuess = document.getElementById("submitGuess");
const feedback = document.getElementById("feedback");
const hint = document.getElementById("hint");
const attemptsLeft = document.getElementById("attemptsLeft");

// Event listener for the guess button
submitGuess.addEventListener("click", () => {
    const guess = parseInt(guessInput.value);

    // Validate input
    if (isNaN(guess) || guess < 1 || guess > 1000) {
        feedback.textContent = "Invalid input! Please enter a number between 1 and 1,000.";
        return;
    }

    attempts++;

    // Check if the guess is correct
    if (guess === randomNumber) {
        feedback.textContent = `Woohoo! You guessed the number in ${attempts} attempts! Nicely done! You are a genius!`;
        hint.textContent = "";
        attemptsLeft.textContent = "";
        guessInput.disabled = true;
        submitGuess.disabled = true;
        return;
    }

    // Provide feedback based on the difference
    const difference = Math.abs(randomNumber - guess);
    if (difference <= 50) {
        feedback.textContent = "You are fiery hot! You are very close to the number!";
    } else if (difference <= 100) {
        feedback.textContent = "You are smoothly warm! You are getting closer to the number!";
    } else if (difference <= 600) {
        feedback.textContent = "Brrr! You are cold! You are far from the number!";
    } else {
        feedback.textContent = "Right now you are extremely super cold! You are very far from the number!";
    }

    // Provide hints on the 3rd attempt
    if (attempts === 3) {
        hint.textContent = `Hint: The number is ${randomNumber % 2 === 0 ? "even" : "odd"}.`;
        if (randomNumber < 10) {
            hint.textContent += " The number is a single-digit number.";
        } else if (randomNumber < 100) {
            hint.textContent += " The number is a double-digit number.";
        } else {
            hint.textContent += " The number is a triple-digit number.";
        }
    }

    // Show remaining attempts
    if (attempts < maxAttempts) {
        attemptsLeft.textContent = `You have ${maxAttempts - attempts} attempts left.`;
    } else {
        feedback.textContent = `Oops! You've reached the maximum number of attempts! The number was ${randomNumber}. See you next time! Over and out!`;
        hint.textContent = "";
        attemptsLeft.textContent = "";
        guessInput.disabled = true;
        submitGuess.disabled = true;
    }
});