document.querySelector('.buy').addEventListener('click', () => {
    const wrapper = document.querySelector(".number-wrapper")
    const price = document.querySelector(".price").value;
    wrapper.innerHTML = '';
    console.log(price)
    if (price < 1000) {
        alert("1000원 이상부터 구매가능합니다.");
        return;
    }
    if (price > 5000) {
        alert("5000원 까지만 구매가능합니다.");
        return;
    }

    let count = Math.floor(price / 1000);

    for (let i = 0; i < count; i++) {
        let randomNum = new Date(Date.now()).getMilliseconds();
        wrapper.innerHTML += `<img src="/random?v=${i + randomNum}"><br>`;
    }
})