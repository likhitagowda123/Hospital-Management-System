const baseUrl = "http://localhost:8080";

window.baseUrl = baseUrl;

function calculateExperience(joiningDate) {
    const joiningDateObj = new Date(joiningDate);

    const currentDate = new Date();

    const millisecondsDiff = currentDate - joiningDateObj;

    const yearsDiff = millisecondsDiff / (1000 * 60 * 60 * 24 * 365);

    const experienceYears = Math.floor(yearsDiff);

    return experienceYears;
}

function formatDate(dateTimeString) {
    // Parse the datetime string into a Date object
    const dateTime = new Date(dateTimeString);
  
    // Format the date using JavaScript's built-in methods
    const formattedDate = (dateTime.getMonth() + 1) + '/' + dateTime.getDate() + '/' + dateTime.getFullYear();
  
    return formattedDate;
  }
