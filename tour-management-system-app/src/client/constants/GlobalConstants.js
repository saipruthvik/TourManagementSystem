export const APIURL = "http://localhost:8080/tourmanagement"

export const prepareDate = (dateStr) => {
    const date = new Date(dateStr);
    return [date.getDate(), date.getMonth() + 1, date.getFullYear()].join("/");
  };