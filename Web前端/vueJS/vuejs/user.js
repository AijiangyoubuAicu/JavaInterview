new Vue({
    el: "#app",
    data: {
        user: {},
        userList: []
    },
    methods: {
        findAll: function () {
            var url = "/vuejs314/user/findAll.do";
            var _this = this;

            axios.get(url).then(function (response) {
                //console.log(response);
                _this.userList = response.data;
            }).catch(function (err) {
                console.log(err)
            });
        },
        update: function () {
            var url = "/vuejs314/user/update.do";
            var _this = this;

            axios.post(url, _this.user).then(function (response) {
                _this.findAll();
            }).catch(function (err) {
                console.log(err)
            });
        },
        findById: function (userid) {
            var url = "/vuejs314/user/findById.do";
            var _this = this;
            axios.get(url, {
                params: {
                    id: userid
                }
            }).then(function (response) {
                //console.log(response);
                _this.user = response.data;
                $("#myModal").modal("show");//让模态框显示
            }).catch(function (err) {
                console.log(err)
            });
        }
    },
    created(){
        this.findAll();
    }
});