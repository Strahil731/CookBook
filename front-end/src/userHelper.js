function setUserData(userData) {
    sessionStorage.setItem("userData", JSON.stringify(userData));
}

function getUserData() {
    return JSON.parse(sessionStorage.getItem("userData"));
}

export {
    setUserData,
    getUserData
}