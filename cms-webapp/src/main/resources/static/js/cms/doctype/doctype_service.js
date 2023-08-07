/**
 * 취합 문서 관리
 */
DoctypeService = {
    loadDetail: function (doctypeId) {
        fetch("/cms/doctype/doc-reg/" + doctypeId, {
            method: "GET"
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if (data.code === "0000") {
                } else {
                    alert("조회 중 오류가 발생했습니다. " + data.code + " : " + data.message);
                }
            })
            .catch(error => console.log(`error => ${error}`));
    },
    fetchByDoctypeId: function (doctypeId) {
    console.log('데이터 패치 - doctypeId : ' + doctypeId);
    fetch("/cms/doctype/set-input-person/" + doctypeId, {method: "GET"})
        .then(res => res.json())
        .then(data => {
            if (data.code === "0000") {
                console.log(data);

            } else {
                alert("조회 중 오류가 발생했습니다. " + data.code + " : " + data.message);
            }
        })
        .catch(error => console.log(`error => ${error}`));
    }


}