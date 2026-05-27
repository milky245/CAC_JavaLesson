// ページ読み込み時
window.onload = function () {

    // タイトルを少し動かす
    const title = document.querySelector("h1");

    title.style.opacity = "0";

    setTimeout(() => {

        title.style.transition = "1s";

        title.style.opacity = "1";

    }, 200);

};