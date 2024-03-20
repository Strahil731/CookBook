// Съхраняване на данните в userData свойството
function setUserData(userData) {
    sessionStorage.setItem("userData", JSON.stringify(userData));
}

// Взимане на данните
function getUserData() {
    return JSON.parse(sessionStorage.getItem("userData"));
}

// Взимане на userToken
function getUserToken() {
    const userData = getUserData();
    return userData?.accessToken;
}

function getUserId(){
    const userData = getUserData();

    return userData?.id;
}

export { setUserData, getUserData, getUserToken, getUserId }