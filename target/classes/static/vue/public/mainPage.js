new Vue({
    el: "#app",
    data: {
        number: 1,
        listData: '',
        page: 1,
        stockInfo: '',
        stockId: '',
        pageInfo: ''
    },
    mounted: function () {
        this.changePage(1);
    },
    methods: {
        change: function (num) {
            this.number = num
        },
        changePage: function (num) {
            this.page = num
            axios.get("http://localhost:8080/winners-list?page=" + this.page).then(
                (response) => {
                    this.listData = response.data.data;
                },
                (err) => {
                    console.error(err);
                }
            )

        },
        searchId: function () {
            if (isNaN(this.stockInfo)) {
                const newVar = axios.get("http://localhost:8080/searchId?name=" + this.stockInfo);
                console.log(newVar)
                console.log("searchId函数： " + this.stockId);

                // 这种方式不行，不管怎么样，then就会成为异步
                // axios.get("http://localhost:8080/searchId?name=" + this.stockInfo).then(
                //     function (res){
                //         console.log(res)
                //         console.log("searchId函数： ");
                //     }
                // )


            } else {
                this.stockId = this.stockInfo;
            }
        },
        submit: function () {
            // await this.searchId();
            // console.log("submit函数： " + this.stockId);

            axios.get("http://stockpage.10jqka.com.cn/" + this.stockInfo).then(
                function (res) {
                    this.pageInfo = res.data.data;
                    console.log(this.pageInfo)
                },
                function (err) {
                    console.log(err)
                }
            )
            // window.location.href = "http://stockpage.10jqka.com.cn/" + this.stockInfo;

        },
        forward: function (id) {
            window.location.href = "http://stockpage.10jqka.com.cn/" + id;

        }

    }
})
