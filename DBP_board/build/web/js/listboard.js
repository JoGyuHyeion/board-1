function Check()
{
    if (Form.keyword.value.length < 1) {
        alert("검색어를 입력하세요.");
        Form.keyword.focus();
        return false;
    }
    if (Form.key.value.length < 1) {
        alert("검색타입을 설정하세요.");
        Form.key.focus();
        return false;
    }
}
function boardWrite(pageNum)
{
    //  alert(pageNum);
    location.href = "./write.jsp?pageNum=" + pageNum;
}