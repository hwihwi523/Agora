// import styled from "styled-components";

// // 진행바
// import ProgressBar from "components/main/signup/progressbar/ProgressBar";

// // SNS 이동 버튼
// import { ProgressButton } from "components/main/signup/Button/SignUpButton";

// // 제목
// import Title from "components/main/signup/title/Title";

// // 라우터 이동을 위한 Link
// import { useNavigate } from "react-router-dom";

// const Wrapper = styled.div`
// `;
// function SignUpSNS() {
//   // 다음 SNS 페이지 이동을 위한 컴포넌트 반환 함수

//   const navigate = useNavigate();

//   const moveToInput = () => {
//     navigate("/user/signup/input")
//   }

//   return (
//     <Wrapper>
//       <ProgressBar />
//       <Title />
//       <h1>추가 정보를 입력해주세요.</h1>
//         <ProgressButton onClick={moveToInput}>
//           완료 후 계속
//         </ProgressButton>
//     </Wrapper>
//   )
// }

// export default SignUpSNS;