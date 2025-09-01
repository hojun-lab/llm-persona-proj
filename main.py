import os
from dotenv import load_dotenv
import google.generativeai as genai

def setup_gemini():
    try:
        # .env 파일에서 환경변수 로드
        load_dotenv()

        # 환경변수에서 API 키 가져오기
        GOOGLE_API_KEY = os.getenv('GOOGLE_API_KEY')

        if not GOOGLE_API_KEY:
            # 환경변수에 없는 경우 사용자 입력 요청
            GOOGLE_API_KEY = input("Google API 키를 입력해주세요: ")
            if not GOOGLE_API_KEY:
                print("⚠️ API 키가 필요합니다")
                return None

        # Gemini 클라이언트 초기화 (google-generativeai 사용)
        genai.configure(api_key=GOOGLE_API_KEY)

        # 간단한 테스트로 API 연결 확인
        try:
            model = genai.GenerativeModel('gemini-2.0-flash-exp')
            response = model.generate_content("Hello")
            print("✅ Gemini API 연결 성공!")
            print(f"테스트 응답: {response.text}")
            return model
        except Exception as e:
            print(f"❌ API 연결 테스트 실패: {e}")
            return None

    except Exception as e:
        print(f"❌ Gemini API 설정 실패: {e}")
        return None


if __name__ == "__main__":
    model = setup_gemini()
    if model:
        # 여기서 모델을 사용할 수 있습니다
        pass