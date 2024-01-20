let darkMode = true;

function toggleTheme() {
  document.body.classList.toggle("dark-mode");

  let buttonText = document.getElementById("theme-btn").firstChild;
  buttonText.data = darkMode ? "Dark-Mode" : "Light-Mode";

  darkMode = !darkMode;
}

//Initial Theme Setup
window.onload = toggleTheme;
