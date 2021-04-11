console.log("Reply Module!");

const replyService = (function () {

    function add(reply, callback) {
        console.log(reply);
        fetch('/replies/', {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(reply),
        })
        .then(res => callback(res.text()))

    }

    async function getList(url) {
        const response = await fetch(url);
        const data = await response.json();
        if (response.ok) {
            // console.log('data:',data);
            return data;
        } else {
            throw new Error(data);
        }
    }

    return {
        add,
        getList
    };
})();