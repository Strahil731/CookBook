function setUserData(userData) {
    sessionStorage.setItem("userData", JSON.stringify(userData));
}

function getUserData() {
    return JSON.parse(sessionStorage.getItem("userData"));
}

function getUserTocken() {
    const userData = getUserData();
    return userData?.accessTocken;
}

export {
    setUserData,
    getUserData,
    getUserTocken
}